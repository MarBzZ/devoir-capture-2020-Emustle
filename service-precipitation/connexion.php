  <?php

//phpinfo();

error_reporting(E_ALL);
ini_set('display_errors', 1);

$usager = 'postgres';
$motdepasse = 'postRoot';
$hote = 'localhost';
$base = 'capture';

$dsn = 'pgsql:dbname='.$base.';host=' . $hote.';port=5432';
$connexion = new PDO($dsn, $usager, $motdepasse);

return $connexion;
?> 