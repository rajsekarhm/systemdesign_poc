# Handle SSL Cerficated in HTTPs - CLient

# 1. download openSSL

## Then,

## Generate private key
## generate Key.pem :
###     command => openssl “” —out key.pem

## Create CSR(certificate security request) using private key  request :
###     command => openssl req -new -key key.pem -out csr.pem

## generate ssl certificate from csr and remove csr.pem if not needed :
##      command => openssl x509 -req -days 365 (expiry) -in csr.pem -signkey key.pem —out cert.pem
