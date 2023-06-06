<?php
$fichier = fopen('texte.dat', "r");
$lines_texte = file('texte.dat');
$lines_comm = fopen('comm.dat', "r");
$lines_tableau = file('tableau.dat');
$lines_regions = file('regions.conf');
$code_region = $argv[1];
$regions = file("regions.conf");
foreach ($regions as $line) {
    $line = substr($line, 5);
    $data = explode(":", $line);
    if ($data[0] == $code_region) {
        $nom_region = $data[1];
        $population = $data[2];
        $superficie = $data[3];
        $nb_departements = $data[4];
    }
}

?>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $nom_region ?></title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <section>
        <h1><?php echo $nom_region; ?></h1>
        <ul>
            <?php
            echo '<li> Population :' . $population . '</li>';
            echo '<li> Superficie :' . $superficie . '</li>';
            echo '<li> Nombre de départements :' . $nb_departements . '</li>';
            ?>
            <li><img src="<?php echo $code_region . '.png'; ?>" title="Logo" alt="Logo de la région" height="200px"></li>

        </ul>
        <div class="bottom">
            <div id="footer"></div>
            <script>
                var today = new Date();
                var date = today.getDate() + '-' + (today.getMonth() + 1) + '-' + today.getFullYear();
                var time = today.getHours() + ":" + today.getMinutes();
                var dateTime = date + ' ' + time;
                document.getElementById("footer").innerHTML = "Généré le " + dateTime;
            </script>
        </div>
    </section>

    <section>
        <h1 id="title"></h1>
        <script>
            var today = new Date();
            var currentMonth = today.getMonth() + 1;
            var currentQuarter = Math.floor((currentMonth - 1) / 3) + 1;
            var currentYear = today.getFullYear();
            document.getElementById("title").innerHTML = "Résultats trimestriels " + currentQuarter + "-" + currentYear + ":";
        </script>
        <br />
        <article>
            <h1><?php echo htmlentities(substr($lines_texte[0], 6)) ?></h1>
            <?php
            while (!feof($fichier)) {
                $line = fgets($fichier);
                if ((strpos($line, "SOUS_TITRE=") !== false) || (strpos($line, "Sous_titre=") !== false)) {
                    $sous_titre = substr($line, 11);
                    echo "<h2>" . $sous_titre . "</h2>";
                }
                if ((strpos($line, "DEBUT_TEXTE") !== false) || (strpos($line, "Début_texte") !== false)) {
                    while ((strpos($line, "FIN_TEXTE") === false) && (strpos($line, "Fin_texte") === false)) {
                        $line = fgets($fichier);
                        if ((strpos($line, "FIN_TEXTE") !== false) || (strpos($line, "Fin_texte") !== false)) {
                            break;
                        } else {
                            echo "<p>" . $line . "</p>";
                        }
                    }
                }
            }
            ?>
        </article>
        <br />

        <table>
            <caption>Tableau des résultats</caption>
            <tr>
                <th>Nom du produit</th>
                <th>Ventes du trimestre</th>
                <th>Chiffre d'affaires du trimestre</th>
                <th>Ventes du même trimestre année précédente</th>
                <th>Chiffres d'affaires du même trimestre de l'année précédente </th>
                <th>Evolution du chiffre d'affaire</th>
            </tr>
            <?php
            foreach ($lines_tableau as $line) {
                if (strpos($line, "DEBUT_STATS") !== false || strpos($line, "FIN_STATS") !== false || strpos($line, "Début_stats") !== false || strpos($line, "Fin_stats") !== false) {
                    continue;
                }
                $valeurs = explode(",", $line);
                echo "<tr>";
                for ($i = 0; $i < count($valeurs); $i++) {
                    echo "<td>$valeurs[$i]</td>";
                }
                $evolution = (($valeurs[4] - $valeurs[2]) / $valeurs[2]) * 100;
                $evolution = number_format($evolution, 2, '.', '');
                if ($evolution >= 0) {
                    echo "<td><span style='color:green; font-weight:bold;'>+$evolution %</span></td>";
                    echo "<td><span style='color:green; font-weight:bold;'>+" . ($valeurs[4] - $valeurs[2]) . "</span></td>";
                } else {
                    echo "<td><span style='color:red; font-weight:bold;'>$evolution %</span></td>";
                    echo "<td><span style='color:red; font-weight:bold;'>" . ($valeurs[4] - $valeurs[2]) . "</span></td>";
                }
                echo "</tr>";
            }
            ?>
        </table>
        <div class="bottom">
            <div id="footer1"></div>
            <script>
                var today = new Date();
                var date = today.getDate() + '-' + (today.getMonth() + 1) + '-' + today.getFullYear();
                var time = today.getHours() + ":" + today.getMinutes();
                var dateTime = date + ' ' + time;
                document.getElementById("footer1").innerHTML = "Généré le " + dateTime;
            </script>
        </div>
    </section>

    <section>
        <h1>Nos meilleurs vendeurs du trimestre :</h1>
        <div style="display: flex;">
            <?php
            $data = "";
            while (($line = fgets($lines_comm)) !== false) {
                if (strpos($line, "MEILLEURS:") === 0) {
                    $data = str_replace("MEILLEURS:", "", $line);
                    break;
                } else if (strpos($line, "Meilleurs:") === 0) {
                    $data = str_replace("Meilleurs:", "", $line);
                    break;
                }
            }
            fclose($lines_comm);
            $lines = explode(",", $data);
            $data_vente = array();
            foreach ($lines as $line) {
                $parts = explode("/", $line);
                $abbreviation = strtolower($parts[0]); # On passe l'abbréviation du nom de MAJUSCULE à minuscule
                $identite = explode("=", $parts[1]); 
                $name = $identite[0]; 
                $ventes = str_replace("K€", "", $identite[1]);
                $identite = explode(" ", $name);
                $prenom = $identite[0];
                $nom_famille = $identite[1]; 
                $data_vente[] = array("abbreviation" => $abbreviation, "prenom" => $prenom, "nom_famille" => $nom_famille, "ventes" => $ventes);
            }
            usort($data_vente, function ($a, $b) {
                return $b['ventes'] <=> $a['ventes'];
            });
            $meilleures_ventes = array_slice($data_vente, 0, 3);
            foreach ($meilleures_ventes as $vendeurs) { 
                echo '<div>';
                echo '<img src="' . $vendeurs["abbreviation"] . '.png" alt="photo of ' . $vendeurs["prenom"] . ' ' . $vendeurs["nom_famille"] . '">';
                echo '<p>Nom: ' . $vendeurs["prenom"] . ' ' . $vendeurs["nom_famille"] . '</p>';
                echo '<p>Chiffre d\'affaires: ' . $vendeurs["ventes"] . 'K€</p>';
                echo '</div>';
            }
            ?>
        </div>
        <div class="bottom">
            <div id="footer2"></div>
            <script>
                var today = new Date();
                var date = today.getDate() + '-' + (today.getMonth() + 1) + '-' + today.getFullYear();
                var time = today.getHours() + ":" + today.getMinutes();
                var dateTime = date + ' ' + time;
                document.getElementById("footer2").innerHTML = "Généré le " + dateTime;
            </script>
        </div>
    </section>

    <!-- Changer le lien -->
    <section>
        <h1><a href="<?php echo "https://bigbrain.biz/" . $code_region; ?>">Lien vers page du site de la société concernant la région</a></h1>
        <figure>
            <img src="qrcode.png" title="QRCode" alt="QRCode" height="200px" style="margin: auto;">
        </figure>
        <div class="bottom">
            <div id="footer3"></div>
            <script>
                var today = new Date();
                var date = today.getDate() + '-' + (today.getMonth() + 1) + '-' + today.getFullYear();
                var time = today.getHours() + ":" + today.getMinutes();
                var dateTime = date + ' ' + time;
                document.getElementById("footer3").innerHTML = "Généré le " + dateTime;
            </script>
        </div>
    </section>

</body>

</html>