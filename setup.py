from setuptools import setup, find_packages

with open("README.md", "r", encoding="utf-8") as fh:
    long_description = fh.read()

with open("requirements.txt", "r", encoding="utf-8") as fh:
    requirements = [
        line.strip() 
        for line in fh 
        if line.strip() and not line.startswith("#") and not line.startswith("-")
    ]

setup(
    name="niu-cast",
    version="1.1.0",
    author="Niumination",
    author_email="niumination@example.com",
    description="Universal Android ADB Tool & Screen Mirroring - Gaming Edition",
    long_description=long_description,
    long_description_content_type="text/markdown",
    url="https://github.com/niumination/niu-cast",
    packages=find_packages(),
    classifiers=[
        "Development Status :: 4 - Beta",
        "Intended Audience :: Developers",
        "Topic :: Software Development :: Build Tools",
        "Topic :: Multimedia :: Video :: Capture",
        "License :: OSI Approved :: MIT License",
        "Programming Language :: Python :: 3",
        "Programming Language :: Python :: 3.8",
        "Programming Language :: Python :: 3.9",
        "Programming Language :: Python :: 3.10",
        "Programming Language :: Python :: 3.11",
        "Operating System :: OS Independent",
    ],
    python_requires=">=3.8",
    install_requires=requirements,
    entry_points={
        "console_scripts": [
            "niu-cast=niu_cast.core:main",
            "niu-mini=niu_cast.mini:main",
            "niu-batch=niu_cast.batch:main",
        ],
    },
    include_package_data=True,
    zip_safe=False,
)