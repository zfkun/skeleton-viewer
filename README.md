Skeleton Viewer
===
Just [Skeleton Viewer](http://zh.esotericsoftware.com/spine-skeleton-viewer)

support x64 (MacOS M1、M2)

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

### DragDrop support
support drop skeleton files to GUI for open directly
> only match the first file ( `*.json`、`*.skel`)


## Build

```
make build-mac
```
