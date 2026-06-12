from setuptools import setup, find_packages

with open("README.md", "r", encoding="utf-8") as fh:
    long_description = fh.read()

with open("requirements.txt", "r", encoding="utf-8") as fh:
    requirements = [line.strip() for line in fh if line.strip() and not line.startswith("#")]

setup(
    name="hermes-cast",
    version="1.0.0",
    author="Hermes Agent",
    author_email="hermes@arena.ai",
    description="Screen mirroring application for Android to Hackintosh",
    long_description=long_description,
    long_description_content_type="text/markdown",
    url="https://github.com/hermes-agent/hermes-cast",
    packages=find_packages(),
    classifiers=[
        "Development Status :: 4 - Beta",
        "Intended Audience :: Developers",
        "Topic :: Software Development :: Build Tools",
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
            "hermes-cast=hermes_cast:main",
            "hermes-mini=hermes_mini:main",
            "hermes-batch=batch_executor:main",
        ],
    },
    include_package_data=True,
    zip_safe=False,
)