<?php

require_once 'db_functions.php';
$db = new DB_Functions();

$response = array();
if(isset($_POST['orderDetail']) && 
    isset($_POST['phone']) &&
    isset($_POST['address']) &&
    isset($_POST['comment']) &&
    isset($_POST['price']))
{
    $phone = $_POST['phone'];
    $orderDetail = $_POST['orderDetail'];
    $orderAddress = $_POST['address'];
    $orderComment = $_POST['comment'];
    $orderPrice = $_POST['price'];

    $result = $db->insertNewOrder($orderPrice, $orderComment, $orderAddress, $orderDetail, $phone);
    if($result)
        echo json_encode("true");
    else
        echo json_encode($result);
}
else
{
    echo json_encode("Required parameter (phone,detail,address,comment,price) is missing!");
}

?>