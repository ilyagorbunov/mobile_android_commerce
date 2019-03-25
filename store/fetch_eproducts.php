<?php

$connection = new mysqli("localhost", "root", "", "store");

$fetchProductsCommand = $connection->prepare("select * from electronic_products where brand=?");
$fetchProductsCommand->bind_param("s", $_GET["brand"]);
$fetchProductsCommand->execute();

$epResult = $fetchProductsCommand->get_result();

$epArray = array();

while ($row = $epResult->fetch_assoc()){

    array_push($epArray, $row);

}

echo json_encode($epArray);

?>