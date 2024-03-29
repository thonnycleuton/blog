$(window).load(function() {
 
      $('#gallery img').each(function() {
 
        createCanvas(this);
      });
 
      function createCanvas(image) {
 
        var canvas = document.createElement('canvas');
        if (canvas.getContext) {
          var ctx = canvas.getContext("2d");
 
// specify canvas size
          canvas.width = image.width;
          canvas.height = image.height;
 
// Once we have a reference to the source image object we can use 
// the drawImage(reference, x, y) method to render it to the canvas. 
//x, y are the coordinates on the target canvas where the image should be placed.
          ctx.drawImage(image, 0, 0);
 
// Taking the image data and storing it in the imageData array. 
//You can read the pixel data on a canvas using the getImageData() method. 
// Image data includes the colour of the pixel (decimal, rgb values) and alpha value. 
// Each color component is represented by an integer between 0 and 255. 
//imageData.data contains height x width x 4 bytes of data, with index values ranging from 0 to (height x width x 4)-1.
          var imageData = ctx.getImageData(0, 0, canvas.width, canvas.height),
              pixelData = imageData.data;
 
// Loop through all the pixels in the imageData array, and modify
// the red, green, and blue color values.
          for (var y = 0; y < canvas.height; y++) {
            for (var x = 0; x < canvas.width; x++) {
 
// You can access the color values of the (x,y) pixel as follows :
              var i = (y * 4 * canvas.width) + (x * 4);
 
// Get the RGB values.
              var red = pixelData[i];
              var green = pixelData[i + 1];
              var blue = pixelData[i + 2];
 
// Convert to grayscale. One of the formulas of conversion (e.g. you could try a simple average (red+green+blue)/3)   
              var grayScale = (red * 0.3) + (green * 0.59) + (blue * .11);
 
              pixelData[i] = grayScale;
              pixelData[i + 1] = grayScale;
              pixelData[i + 2] = grayScale;
            }
          }
 
// Putting the modified imageData back on the canvas.
          ctx.putImageData(imageData, 0, 0, 0, 0, imageData.width, imageData.height);
 
// Inserting the canvas in the DOM, before the image:
          image.parentNode.insertBefore(canvas, image);
        }
      }
    });// JavaScript Document