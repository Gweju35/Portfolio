#!/usr/bin/php
<?php
$file = $argv[1]; 
$fichier = fopen($file, "r");
$fichier_texte = fopen("texte.dat", "a");
$debut_texte = 'DEBUT_TEXTE';
$fin_texte = 'FIN_TEXTE';
$titre = 'SOUS_TITRE=';
$code = 'CODE=';
$meilleurs = 'MEILLEURS:';

$fichier_comm = fopen("comm.dat", "a");

$fichier_tab = fopen("tableau.dat", "a");
$debut_tab = 'DEBUT_STATS';
$fin_tab = 'FIN_STATS';

$code2 = 'Code=';
$debut_texte2 = 'Début_texte';
$fin_texte2 = 'Fin_texte';
$titre2 = 'Sous_titre=';
$meilleurs2 = 'Meilleurs:';
$debut_tab2 = 'Début_stats';
$fin_tab2 = 'Fin_stats';

while (!feof($fichier)) {
  $line = fgets($fichier);

  // En majuscules
  /*Extraction du titre*/
  if (strpos($line, $code) !== false) {
    while (strpos($line, $debut_texte) === false) {
      $line = fgets($fichier);
      if (strpos($line, $debut_texte) === false) {
        fwrite($fichier_texte, $line);
      }
    }
  }

  /*Extraction des sous-titres*/
  if (strpos($line, $titre) !== false) {
    fwrite($fichier_texte, $line);
  }

  /*Extraction du texte*/
  if (strpos($line, $debut_texte) !== false) {
    fwrite($fichier_texte, $line);
    while (strpos($line, $fin_texte) === false) {
      $line = fgets($fichier);
      fwrite($fichier_texte, $line);
    }
  }

  /*Extraction des données du tableau*/
  if (strpos($line, $debut_tab) !== false) {
    fwrite($fichier_tab, $line);
    while (strpos($line, $fin_tab) === false) {
      $line = fgets($fichier);
      fwrite($fichier_tab, $line);
    }
  }

  /*Extraction des noms des meilleurs commerciaux*/
  if (strpos($line, $meilleurs) !== false) {
    fwrite($fichier_comm, $line);
  }

  // En minuscules
  /*Extraction du titre*/
  if (strpos($line, $code2) !== false) {
    while (strpos($line, $debut_texte2) === false) {
      $line = fgets($fichier);
      if (strpos($line, $debut_texte2) === false) {
        fwrite($fichier_texte, $line);
      }
    }
  }

  /*Extraction des sous-titres*/
  if (strpos($line, $titre2) !== false) {
    fwrite($fichier_texte, $line);
  }

  /*Extraction du texte*/
  if (strpos($line, $debut_texte2) !== false) {
    fwrite($fichier_texte, $line);
    while (strpos($line, $fin_texte2) === false) {
      $line = fgets($fichier);
      fwrite($fichier_texte, $line);
    }
  }

  /*Extraction des données du tableau*/
  if (strpos($line, $debut_tab2) !== false) {
    fwrite($fichier_tab, $line);
    while (strpos($line, $fin_tab2) === false) {
      $line = fgets($fichier);
      fwrite($fichier_tab, $line);
    }
  }

  /*Extraction des noms des meilleurs commerciaux*/
  if (strpos($line, $meilleurs2) !== false) {
    fwrite($fichier_comm, $line);
  }
}
fclose($fichier);
fclose($fichier_texte);
fclose($fichier_comm);
fclose($fichier_tab);
?>