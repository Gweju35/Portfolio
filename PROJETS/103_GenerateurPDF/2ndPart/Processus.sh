#!/bin/bash
regions=("Auvergne-Rhône-Alpes" "Bretagne" "Bourgogne-Franche-Comté" "Centre-Val de Loire" "Corse" "Grand Est" "Hauts-de-France" "Île-de-France" "Normandie" "Nouvelle-Aquitaine" "Occitanie" "Pays de la Loire" "Provence-Alpes-Côte d'Azur")

echo "Quel est votre login ?"
read login
echo "Donnez le chemin du dossier où le processus s'effectuera "
read chemin
echo "Donnez le chemin du dossier où vous souhaitez stocker ces PDF"
read dossier

for region in "${regions[@]}"
do
    echo "Création du PDF pour la région $region"
    if [ "$region" == "Auvergne-Rhône-Alpes" ] then code_iso == 'FR-ARA' fi
    if [ "$region" == "Bretagne" ] then code_iso == 'FR-BRE' fi
    if [ "$region" == "Bourgogne-Franche-Comté" ] then code_iso == 'FR-BFC' fi
    if [ "$region" == "Centre-Val de Loire" ] then code_iso == 'FR-CVL' fi
    if [ "$region" == "Corse" ] then code_iso == 'FR-COR' fi
    if [ "$region" == "Grand Est" ] then code_iso == 'FR-GES' fi
    if [ "$region" == "Hauts-de-France" ] then code_iso == 'FR-HDF' fi
    if [ "$region" == "Île-de-France" ] then code_iso == 'FR-IDF' fi
    if [ "$region" == "Normandie" ] then code_iso == 'FR-NOR' fi
    if [ "$region" == "Nouvelle-Aquitaine" ] then code_iso == 'FR-NAQ' fi
    if [ "$region" == "Occitanie" ] then code_iso == 'FR-OCC' fi
    if [ "$region" == "Pays de la Loire" ] then code_iso == 'FR-PDL' fi
    if [ "$region" == "Provence-Alpes-Côte d'Azur" ] then code_iso == 'FR-PAC' fi

    fichier_texte = "$region.txt"
    url = "https://bigbrain.biz/$code_iso"
    QRCODE = "QRCode_$code_iso.png"
    html = "$code_iso.html"
    pdf = "$code_iso.pdf"

    docker pull image sae103-php
    docker run image sae103-php -it --rm
    docker run -it --rm -v /Docker/$chemin:/work -w /work sae103-php ./script.php $fichier_texte
    container_id=$(docker run -d sae103-php)
    docker stop $container_id

    docker pull image sae103-imagick
    docker run image sae103-imagick -it --rm
    docker run -it --rm -v /Docker/$chemin:/images -w /images sae103-imagick bash -c './conversion.sh'
    container_id=$(docker run -d sae103-imagick)
    docker stop $container_id

    docker pull image qrcode
    docker container run qrcode -it --rm
    docker run -it --rm -v "$PWD":/app qrcode sh -c "echo $url | qrencode -o /app/$chemin/$QRCODE"
    container_id=$(docker run -d qrcode)
    docker stop $container_id

    docker pull image sae103-php
    docker run image sae103-php -it --rm
    docker run -it --rm -v "$PWD":/app -w /app sae103-php php ConversionHTML.php $code_iso > $html
    container_id=$(docker run -d sae103-php)
    docker stop $container_id

    docker pull image html2pdf
    docker run image html2pdf -it --rm
    docker run -it --rm -v /Docker/$login:/work sae103-html2pdf "html2pdf $html $pdf"
    container_id=$(docker run -d html2pdf)
    docker stop $container_id

    rm $chemin/*.dat
done
mv $chemin/*.pdf $dossier
tar czvf PDF-sae103.tar.gz $dossier