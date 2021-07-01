# Image Steganography
<p align="justify">
Steganography is the practice of hiding a secret message inside of (or even on top of) something that is not secret. That something can be just about anything you want. These days, many examples of steganography involve embedding a secret piece of text inside of a picture. Or hiding a secret message or script inside of a Word or Excel document. 
The purpose of steganography is to conceal and deceive. It is a form of covert communication and can involve the use of any medium to hide messages. It’s not a form of cryptography, because it doesn’t involve scrambling data or using a key. Instead, it is a form of data hiding and can be executed in clever ways
</p><br>

<b> Least Significant Bit (LSB) Method </b>
<p align="justify"> The Least Significant Bit (LSB) steganography is one such technique in which least significant bit of the image is
replaced with data bit. As this method is vulnerable to steganalysis so as to make it more secure we encrypt the raw
data before embedding it in the image. Though the encryption process increases the time complexity, but at the same
time provides higher security also. This approach is very simple. In this method the least significant bits of some or
all of the bytes inside an image is replaced with a bits of the secret message. The LSB embedding approach has
become the basis of many techniques that hide messages within multimedia carrier data. </p>
<br>
<b> PNG Image Structure </b>
<br><br>
![alt text](/images/image1.png)
