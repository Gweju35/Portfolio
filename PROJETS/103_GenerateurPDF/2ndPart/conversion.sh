#!/bin/bash
if [ $# -lt 1 ]; then
  echo "Usage: $0 repertoire"
  exit 1
fi
repertoire=$1
for file in $repertoire/*; #on parcourt tous les fichiers qui sont dans le répertoire donné
do
  if [[ $file == *.svg ]] #on vérifie que les images sont en '.svg'
  then
  convert -resize 200x200 -colorspace Gray "$file" "${file%.*}.png" # *
  fi
done

# *
# -resize 200x200, redimensionne l'image en 200 pixels par 200 pixels
# -colorspace Gray, convertit l'image en nuance de gris
# "$file" "${file%.*}.png", convertit les images en png