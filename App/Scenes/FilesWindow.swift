import SwiftUI
import SharedModels
import SharedModels

struct FilesWindow: View {
    let device: ADBDevice
    @StateObject private var viewModel = FilesViewModel()
    @State private var showingFilePicker = false
    @State private var draggedFile: FileItem?
    
    var body: some View {
        VStack(spacing: 0) {
            // Toolbar
            HStack {
                Button(action: { navigateUp() }) {
                    Image(systemName: "arrow.up")
                }
                .disabled(viewModel.currentPath == "/")
                
                Text(viewModel.currentPath)
                    .font(.caption)
                    .lineLimit(1)
                    .truncationMode(.middle)
                
                Spacer()
                
                Button("Upload") {
                    showingFilePicker = true
                }
                
                Button("New Folder") {
                    // TODO: Show create folder dialog
                }
            }
            .padding()
            .background(.ultraThinMaterial)
            
            // File list
            if viewModel.isLoading {
                ProgressView("Loading...")
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
            } else if viewModel.files.isEmpty {
                VStack {
                    Image(systemName: "folder")
                        .font(.system(size: 40))
                        .foregroundStyle(.secondary)
                    Text("No files")
                        .foregroundStyle(.secondary)
                }
                .frame(maxWidth: .infinity, maxHeight: .infinity)
            } else {
                List {
                    ForEach(viewModel.files) { file in
                        FileRow(file: file) {
                            if file.isDirectory {
                                navigateTo(file.path)
                            }
                        }
                        .contextMenu {
                            Button("Delete") {
                                deleteFile(file)
                            }
                        }
                    }
                }
            }
        }
        .onAppear {
            navigateTo("/sdcard")
        }
        .fileImporter(
            isPresented: $showingFilePicker,
            allowedContentTypes: [.data, .directory],
            allowsMultipleSelection: true
        ) { result in
            handleFileImport(result)
        }
        .onDrop(of: [.fileURL], isTargeted: nil) { providers in
            handleDrop(providers)
        }
    }
    
    private func navigateUp() {
        let parent = viewModel.navigateUp()
        navigateTo(parent)
    }
    
    private func navigateTo(_ path: String) {
        Task {
            await viewModel.listFiles(path: path, serial: device.serial)
        }
    }
    
    private func deleteFile(_ file: FileItem) {
        Task {
            try? await viewModel.deleteFile(path: file.path, serial: device.serial)
            navigateTo(viewModel.currentPath)
        }
    }
    
    private func handleFileImport(_ result: Result<[URL], Error>) {
        switch result {
        case .success(let urls):
            for url in urls {
                let fileName = url.lastPathComponent
                let remotePath = viewModel.currentPath.hasSuffix("/") 
                    ? "\(viewModel.currentPath)\(fileName)"
                    : "\(viewModel.currentPath)/\(fileName)"
                
                Task {
                    try? await viewModel.pushFile(
                        localPath: url.path,
                        remotePath: remotePath,
                        serial: device.serial
                    )
                }
            }
            navigateTo(viewModel.currentPath)
        case .failure(let error):
            print("File import error: \(error)")
        }
    }
    
    private func handleDrop(_ providers: [NSItemProvider]) -> Bool {
        for provider in providers {
            if provider.canLoadObject(ofClass: URL.self) {
                _ = provider.loadObject(ofClass: URL.self) { url, _ in
                    guard let url = url else { return }
                    let fileName = url.lastPathComponent
                    let remotePath = self.viewModel.currentPath.hasSuffix("/")
                        ? "\(self.viewModel.currentPath)\(fileName)"
                        : "\(self.viewModel.currentPath)/\(fileName)"
                    
                    Task {
                        try? await self.viewModel.pushFile(
                            localPath: url.path,
                            remotePath: remotePath,
                            serial: self.device.serial
                        )
                        self.navigateTo(self.viewModel.currentPath)
                    }
                }
            }
        }
        return true
    }
}

struct FileRow: View {
    let file: FileItem
    let onTap: () -> Void
    
    var body: some View {
        HStack {
            Image(systemName: file.isDirectory ? "folder.fill" : "doc")
                .foregroundStyle(file.isDirectory ? .blue : .secondary)
            
            VStack(alignment: .leading) {
                Text(file.name)
                    .font(.body)
                if !file.isDirectory {
                    Text(formatSize(file.size))
                        .font(.caption)
                        .foregroundStyle(.secondary)
                }
            }
            
            Spacer()
        }
        .contentShape(Rectangle())
        .onTapGesture {
            onTap()
        }
    }
    
    private func formatSize(_ bytes: Int64) -> String {
        let formatter = ByteCountFormatter()
        formatter.countStyle = .file
        return formatter.string(fromByteCount: bytes)
    }
}
