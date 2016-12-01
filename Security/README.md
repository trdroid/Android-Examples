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
* Getting one from a trusted Certificate Authority (CA) like "VeriSign"

**Storage**

Digital certificates are stored in *keystores*. 

A *keystore* stores a list of digital certificates. 
Each digital certificate in the *keystore* has an *alias* that can be used to address its corresponding digital certificate. 

### Signing an Android application

Signing an Android application requires

* The .apk file to be signed
* A digital certificate
* A utility to apply the digital certificate to the .apk file

**Benefits**

An Android application signed with a digital certificate 

* CAN ONLY BE UPDATED by the original author of the application who holds the digital certificate used to initially sign and deploy the app.
