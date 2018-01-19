<?php session_start(); ?>
<?php
    extract($_POST); 
    extract($_GET);

    if(!isset($_SESSION["login"])){
        header("Location: login.php?error=<p>not valid</p>"); die();
    }

    if(!isset($answer)){
        $score=0;
        $total=0;
    }

    if (isset($answer)){
        if(is_numeric($answer)){
            if ($answer == $result){
                $score++;
                $total++;
                $msg = "";
            } else {
                $msg = "<p style= 'color:red;'>INCORRECT, $first $sign $second is $result</p>";
                $total++;
            }
        } else{
            $msg = "<p style= 'color:red;'>You must enter a number for your answers.</p>";
        }
    }

    $first = rand(0,50);
    $second = rand(0,50);
    $sign = rand(0,1);
    if ($sign==0){
        $sign="+";
        $result = $first + $second;
    } else{
        $sign="-";
        $result = $first - $second;
    }
?>

<html lang='en'>
<head>
    <title>Random Math</title>
    <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <div class="container">
        <form action="validator.php" method="post" class="form-horizontal">
            <div class="col-sm-3 col-sm-offset-9">
                <button type="submit" class="btn btn-default" name="logout">Logout</button>
            </div>
        </form>
        <form class="form-horizontal" action="index.php" method="post">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4">
                    <h1>Math Game</h1>
                </div>
            </div>
            <div class="row">
                <label class="col-sm-2 col-sm-offset-3">
                    <?php echo $first; ?>
                </label>
                <label class="col-sm-2">
                    <?php echo $sign; ?>
                </label>
                <label class="col-sm-2">
                    <?php echo $second; ?>
                </label>
                <label class="col-sm-3"></label>
            </div>
            <div class="row">
                <input type="hidden" id="first" name="first" value="<?php echo $first; ?>"/>
                <input type="hidden" id="second" name="second" value="<?php echo $second; ?>"/>
                <input type="hidden" id="sign" name="sign" value="<?php echo $sign; ?>"/>
                <input type="hidden" id="result" name="result" value="<?php echo $result; ?>"/>
                <input type="hidden" id="score" name="score" value="<?php echo $score; ?>"/>
                <input type="hidden" id="total" name="total" value="<?php echo $total; ?>"/>
 
                <div class="col-sm-3 col-sm-offset-4">
                <input type="text" class="form-control" id="answer" name="answer" placeholder="Enter answer">
                </div>
                <div class="col-sm-5"></div>
            </div>
            <div class="row">
                <div class="col-sm-3 col-sm-offset-4">
                    <button type="submit" class="btn btn-primary btn-sm" name="submit">Submit</button>
                </div>
                <div class="col-sm-5"></div>
            </div>
        </form>
        <hr>
        <div class="row">
            <div class="col-sm-4 col-sm-offset-4">
                <?php echo $msg; ?>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 col-sm-offset-4">
                <?php echo "Score: $score / $total"; ?>
            </div>
        </div>
        
    </div>
</body>
</html>