<?php

require_once 'db_functions.php';
$db = new DB_Functions();

$products = $db->getAllProducts();
if($products)
    echo json_encode($products);
else
    echo json_encode("Error !");

?>