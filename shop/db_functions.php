<?php

class DB_Functions{
    private $conn;

    function __construct()
    {
        require_once 'db_connect.php';
        $db = new DB_Connect();
        $this->conn = $db->connect();
    }

    function __destruct(){

    }

    function checkExistsUser($phone)
    {
        $stnt = $this->conn->prepare("SELECT * FROM User WHERE Phone=?");
        $stnt->bind_param("s", $phone);
        $stnt->execute();
        $stnt->store_result();

        if($stnt->num_rows > 0)
        {
            $stnt->close();
            return true;
        }
        else
        {
            $stnt->close();
            return false;
        }
    }

    public function registerNewUser($phone, $name, $birthdate, $address)
    {
        $stnt = $this->conn->prepare("INSERT INTO User(Phone, Name, Birthdate, Address) VALUES(?,?,?,?)");
        $stnt->bind_param("ssss", $phone, $name, $birthdate, $address);
        $result=$stnt->execute();
        $stnt->close();

        if($result)
        {
            $stnt=$this->conn->prepare("SELECT * FROM User WHERE Phone=?");
            $stnt->bind_param("s", $phone);
            $stnt->execute();
            $user = $stnt->get_result()->fetch_assoc();
            $stnt->close();
            return $user;
        }
        else
        {
            return false;
        }
    }

    public function getUserInformation($phone)
    {
        $stnt = $this->conn->prepare("SELECT * FROM User WHERE Phone=?");
        $stnt->bind_param("s", $phone);

        if($stnt->execute())
        {
            $user = $stnt->get_result()->fetch_assoc();
            $stnt->close();

            return $user;
        }
        else
        {
            return NULL;
        }
    }

    public function getBanners()
    {
        $result = $this->conn->query("SELECT * FROM Banner ORDER BY ID LIMIT 3");

        $banners = array();

        while($item = $result->fetch_assoc())
            $banners[] = $item;
        return $banners;
    }

    public function getMenu()
    {
        $result = $this->conn->query("SELECT * FROM Menu ORDER BY ID");

        $menu = array();

        while($item = $result->fetch_assoc())
            $menu[] = $item;
        return $menu;
    }

    public function getProductByMenuID($menuId)
    {
        $query = "SELECT * FROM Product Where MenuId='".$menuId."'";
        $result = $this->conn->query($query);

        $products = array();

        while($item = $result->fetch_assoc())
            $products[] = $item;
        return $products;
    }

    public function updateAvatar($phone,$fileName)
    {
        return $result = $this->conn->query("UPDATE user SET avatarUrl='$fileName' WHERE Phone='$phone'");
    }

    public function getAllProducts()
    {
        $result = $this->conn->query("SELECT * FROM product WHERE 1") or die($this->conn->error);

        $products = array();
        while($item = $result->fetch_assoc())
            $products[] = $item;
        return $products;
    }

    public function insertNewOrder($orderPrice, $orderComment, $orderAddress, $orderDetail, $userPhone){
        $stmt = $this->conn->prepare("INSERT INTO `order`(`OrderStatus`, `OrderPrice`, `OrderDetail`, `OrderComment`, `OrderAddress`, `UserPhone`) VALUES (0,?,?,?,?,?)")
        or die($this->conn->error);
        $stmt->bind_param("sssss", $orderPrice, $orderDetail, $orderComment, $orderAddress, $userPhone);
        $result = $stmt->execute();
        $stmt->close();

        if($result)
            return true;
        else
            return false;
    }
}

?>