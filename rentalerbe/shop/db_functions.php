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
}

?>