<?php

class BaseDeDonnees
{
    public static function getConnection()
    {        
        error_reporting(E_ALL);
        ini_set('display_errors', 1);
    
        $usager = 'hyvong';
        $motdepasse = 'postRoot';
        $hote = 'localhost';
        $base = 'capture';
    
        $dsn = 'pgsql:dbname='.$base.';host=' . $hote.';port=5432';
        $connexion = new PDO($dsn, $usager, $motdepasse);
    
        return $connexion;
    }
}

?>
