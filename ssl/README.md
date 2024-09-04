# Handle SSL Cerficated in HTTPs - CLient

# 1. download openSSL

## Then,

## Generate private key

## generate Key.pem :

### command => openssl genpkey -algorithm RSA -out key.pem

## Create CSR(certificate security request) using private key request and generate ssl certificate from csr and remove csr.pem if not needed :

### command => openssl req -x509 -newkey rsa:2048 -keyout key.pem -out cert.pem -days 365
