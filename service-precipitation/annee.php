<?php

include "PrecipitationDAO.php";

$paramAnnee = filter_var($_GET["annee"], FILTER_VALIDATE_INT);

if(!empty($paramAnnee))
{
    $annee = PrecipitationDAO::listerStatsAnnee($paramAnnee);
    $listeMois = PrecipitationDAO::listerMois($paramAnnee);
}

header("Content-Type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<precipitations>
<?php
foreach($listeMois as $mois)
{
?>
    <precipitation>
		<mois><?php echo $mois['mois'];?></mois>
        <moyenne><?php echo  number_format($mois['moyenne'],1);?></moyenne>
        <min><?php echo  number_format($mois['min'],1);?></min>
        <max><?php echo  number_format($mois['max'],1);?></max>
    </precipitation>
<?php
}
?>
    <moyenne><?php echo  number_format($annee['moyenne'],1);?></moyenne>
	<min><?php echo  number_format($annee['min'],1);?></min>
	<max><?php echo  number_format($annee['max'],1);?></max>
</precipitations>
