#!/bin/bash
HTML_FILE=$1 # le nom du fichier HTML utilisé
PDF_FILE=$2 # le nom du fichier PDF qui sera créer
HTML2PDF_IMAGE=$3 # l'image qui a été pull

echo "Veuillez entrer votre login :"
read login

docker run --rm -ti -v /Docker/$login:/work $HTML2PDF_IMAGE "html2pdf $HTML_FILE $PDF_FILE"







