ROOT_DIR = $(shell pwd)

APP_VERSION = 1.0.0
APP_NAME = SkeletonViewer

BUILD_DIR = desktop/build/libs
DESKTOP_JAR = desktop-1.0.0.jar

.PHONY: build-mac
build-mac:
	jpackage --name $(APP_NAME) \
		--dest ./build \
		--input $(BUILD_DIR) \
		--java-options "-Xms128m -Xmx1500m -XstartOnFirstThread" \
		--main-jar $(DESKTOP_JAR) \
		--icon ./tools/icon.icns \
		--app-version $(APP_VERSION)

.PHONY: build-windows
build-windows:
	jpackage --type exe \
		--name $(APP_NAME) \
		--dest ./build \
		--input $(BUILD_DIR) \
		--java-options "-Xms128m -Xmx1500m" \
		--main-jar  $(DESKTOP_JAR) \
		--icon ./tools/icon.ico \
		--app-version $(APP_VERSION) \
		--vendor raven \
		--win-dir-chooser \
		--win-shortcut \
		--win-menu \
		--win-menu-group "SkeletonViewer"
