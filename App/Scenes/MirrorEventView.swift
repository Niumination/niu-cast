import SwiftUI
import AppKit

/// View that captures mouse/keyboard events and sends to Android
struct MirrorEventView: NSViewRepresentable {
    let onMouseEvent: (MouseEvent) -> Void
    let onKeyboardEvent: (KeyboardEvent) -> Void
    
    func makeNSView(context: Context) -> EventCaptureView {
        let view = EventCaptureView()
        view.onMouseEvent = onMouseEvent
        view.onKeyboardEvent = onKeyboardEvent
        return view
    }
    
    func updateNSView(_ nsView: EventCaptureView, context: Context) {
        nsView.onMouseEvent = onMouseEvent
        nsView.onKeyboardEvent = onKeyboardEvent
    }
}

/// Mouse event data
struct MouseEvent {
    let type: EventType
    let x: CGFloat
    let y: CGFloat
    let button: MouseButton
    
    enum EventType {
        case moved, pressed, released, dragged, scroll
    }
    
    enum MouseButton {
        case left, right, middle, none
    }
}

/// Keyboard event data
struct KeyboardEvent {
    let type: EventType
    let keyCode: UInt16
    let characters: String?
    let modifiers: NSEvent.ModifierFlags
    
    enum EventType {
        case keyDown, keyUp, flagsChanged
    }
}

class EventCaptureView: NSView {
    var onMouseEvent: ((MouseEvent) -> Void)?
    var onKeyboardEvent: ((KeyboardEvent) -> Void)?
    
    override var acceptsFirstResponder: Bool { true }
    
    override func viewDidMoveToWindow() {
        super.viewDidMoveToWindow()
        window?.makeFirstResponder(self)
    }
    
    // MARK: - Mouse Events
    
    override func mouseDown(with event: NSEvent) {
        let point = convert(event.locationInWindow, from: nil)
        onMouseEvent?(MouseEvent(type: .pressed, x: point.x, y: point.y, button: .left))
    }
    
    override func mouseUp(with event: NSEvent) {
        let point = convert(event.locationInWindow, from: nil)
        onMouseEvent?(MouseEvent(type: .released, x: point.x, y: point.y, button: .left))
    }
    
    override func rightMouseDown(with event: NSEvent) {
        let point = convert(event.locationInWindow, from: nil)
        onMouseEvent?(MouseEvent(type: .pressed, x: point.x, y: point.y, button: .right))
    }
    
    override func rightMouseUp(with event: NSEvent) {
        let point = convert(event.locationInWindow, from: nil)
        onMouseEvent?(MouseEvent(type: .released, x: point.x, y: point.y, button: .right))
    }
    
    override func mouseMoved(with event: NSEvent) {
        let point = convert(event.locationInWindow, from: nil)
        onMouseEvent?(MouseEvent(type: .moved, x: point.x, y: point.y, button: .none))
    }
    
    override func mouseDragged(with event: NSEvent) {
        let point = convert(event.locationInWindow, from: nil)
        onMouseEvent?(MouseEvent(type: .dragged, x: point.x, y: point.y, button: .left))
    }
    
    override func scrollWheel(with event: NSEvent) {
        let point = convert(event.locationInWindow, from: nil)
        onMouseEvent?(MouseEvent(type: .scroll, x: point.x, y: point.y, button: .none))
    }
    
    // MARK: - Keyboard Events
    
    override func keyDown(with event: NSEvent) {
        onKeyboardEvent?(KeyboardEvent(
            type: .keyDown,
            keyCode: event.keyCode,
            characters: event.characters,
            modifiers: event.modifierFlags
        ))
    }
    
    override func keyUp(with event: NSEvent) {
        onKeyboardEvent?(KeyboardEvent(
            type: .keyUp,
            keyCode: event.keyCode,
            characters: event.characters,
            modifiers: event.modifierFlags
        ))
    }
    
    override func flagsChanged(with event: NSEvent) {
        onKeyboardEvent?(KeyboardEvent(
            type: .flagsChanged,
            keyCode: event.keyCode,
            characters: nil,
            modifiers: event.modifierFlags
        ))
    }
}
