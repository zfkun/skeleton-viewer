Skeleton Viewer
===
Just [Skeleton Viewer](http://zh.esotericsoftware.com/spine-skeleton-viewer)

support x64 (Windows, MacOS M1、M2)

## Version

- Skeleton Viewer 2.2.x for Spine 4.2.x
- Skeleton Viewer 2.1.x for Spine 4.1.x
- Skeleton Viewer 2.0.x for Spine 4.0.x
- Skeleton Viewer 1.0.x for Spine 3.8.x

## Issue

### GUI Block
GUI will be blocked when FileDialog visible by click open button  

```java
// ...
new FileDialog((Frame)null, "");
// ...
// can show, but blocked finally 
fileDialog.setModalityType(Dialog.ModalityType.MODELESS);
// ...
setVisible(true);
// ...
```

## Feature

### Support X64
support x64, arm64
> MacOS M1, M2
> Windows x64

### DragDrop support
support drop skeleton files to GUI for open directly
> only match the first file ( `*.json`、`*.skel`)


## Packaging

> in windows, need [Wix3](https://github.com/wixtoolset/wix3/releases)

```shell
.\gradlew :desktop:pack
```

> packaging output to `desktop/pack/*`
