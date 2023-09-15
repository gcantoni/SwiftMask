<h1 align="center">Swift Mask</h1>
<h4 align="center">Real time face mask detection</h4>
<h3 align="center"><img src="https://raw.githubusercontent.com/gcantoni/swiftWallWallpapers/master/swift_mask.png" height="150" width="150"/></h3>

## Brief overview
Swift Mask scans images or human faces in real time and detects whether the mask is worn or not, with the ability to set an audible alert.

## Building
To correctly compile the project it is necessary to have a  <a href="https://www.tensorflow.org/lite/guide">TensorFlow Lite model</a> (.tflite) containing the dataset of people wearing or not wearing a mask. It should be placed under <a href="https://github.com/gcantoni/SwiftMask/tree/main/app/src/main/assets">/assets</a> with the name of <i>mask_detector</i> 

## Screenshots
<h3 align="center"><img src="https://raw.githubusercontent.com/gcantoni/swiftWallWallpapers/master/swift_mask_ss.png"/></h3>

## Credits
This application is based on the <a href="https://www.tensorflow.org/lite/examples/image_classification/overview">Image classification</a> example by TensorFlow. This application adds the <a href="https://developers.google.com/ml-kit">MLKit</a> to implement face detection and a <a href="https://material.io/blog/announcing-material-you">Material You</a> based user interface.
