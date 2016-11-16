# Android Security Model

An Android application must be signed with a digital certificate to deploy/install it on a device. 

### Digital Certificate

**Content**

A digital certificate contains the following information

* Author related, like the compnay name, address etc.
* Signature
* Public/Private key

**Usage**

Digital certificates can be used for

* Signing .apk files
* Signing documents
* Encrypting communications

**Obtaining a Digital Certificate**

A *digital certificate* can be obtained by

* Generating one individually using tools like *keytool*
* Getting one from a trusted Certificate Authority (CA)

### Signing an Android application

An Android application signed with a digital certificate CAN ONLY BE UPDATED by the original author of the application who holds the digital certificate used to initially sign and deploy the app.
