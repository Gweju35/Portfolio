#!/bin/bash
code_region=$1 # On récupère le code ISO 3166-2 de la région souhaitée
repertoire_de_sortie=$2 # On récupère le répertoire où sera copié le QRCode généré
url="https://bigbrain.biz/$code_region" # URL à coder dans le QRCode
qrencode -o "$repertoire_de_sortie/QRCode_$code_region.png" "$url" # On génère le QRCode avec l'URL codé dedans
echo "QRCode généré dans le répertoire $repertoire_de_sortie" # Message pour indiquer que le QRCode a été créer