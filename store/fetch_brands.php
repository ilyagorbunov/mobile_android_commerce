<?php

$connection = new mysqli("localhost", "root", "", "store");

$selectBrandsCommand = $connection->prepare("select distinct brand from electronic_products");
$selectBrandsCommand->execute();

$brandResult = $selectBrandsCommand->get_result();

$brands = array();

while ($row = $brandResult->fetch_assoc()){

    array_push($brands, $row);

}

echo json_encode($brands);

?>