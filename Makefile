ROOT_DIR = $(shell pwd)

BUILD_DIR = desktop/build/libs

.PHONY: build-mac
build-mac:
	jpackage --name SkeletonViewer \
            --dest ./build \
			--input $(BUILD_DIR) \
			--java-options "-Xms128m -Xmx1500m -XstartOnFirstThread" \
			--main-jar desktop-1.0.0.jar \
			--icon ./tools/icon.icns \
			--app-version 1.0.0
