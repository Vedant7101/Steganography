# Image Steganography
<p align="justify">
Steganography is the practice of hiding a secret message inside of (or even on top of) something that is not secret. That something can be just about anything you want. These days, many examples of steganography involve embedding a secret piece of text inside of a picture. Or hiding a secret message or script inside of a Word or Excel document. 
The purpose of steganography is to conceal and deceive. It is a form of covert communication and can involve the use of any medium to hide messages. It’s not a form of cryptography, because it doesn’t involve scrambling data or using a key. Instead, it is a form of data hiding and can be executed in clever ways
</p><br>

### Least Significant Bit (LSB) Method
<p align="justify"> The Least Significant Bit (LSB) steganography is one such technique in which least significant bit of the image is
replaced with data bit. As this method is vulnerable to steganalysis so as to make it more secure we encrypt the raw
data before embedding it in the image. Though the encryption process increases the time complexity, but at the same
time provides higher security also. This approach is very simple. In this method the least significant bits of some or
all of the bytes inside an image is replaced with a bits of the secret message. The LSB embedding approach has
become the basis of many techniques that hide messages within multimedia carrier data. </p>
<br>

### PNG Image Structure
<br><br>

![alt text](/images/image1.png)

<br>
<p> Each pixel of PNG image contains 4 colors i.e. Red, Green, Blue and Alpha. In this application, Alpha is used to hide text. Alpha represents opacity of image. In this application, last 2 bits of Alpha is changed. Each character in secret text is represented by 8 bit. Application stores 2 bits of secret text in each pixel. Therefore, 4 pixels are required to store single character. 
<br><br>  
  <b> Encryption Steps </b>
  
  1. Select Image
  2. Get plain text from user.
  3. Get key from user.
  4. Convert normal text to cipher text.
  5. Hide key + plain text inside pixels.
  
  <br>
  <b> Decryption Steps </b>
 
  1. Select Image
  2. Get key from user.
  3. Decipher key and plain text.
  4. Match key inside image with key received from user.
  5. If there is match, show secret text. If not, show error message.
  
<br>

### Application Image

<br>
  
![alt text](/images/image2.png)
