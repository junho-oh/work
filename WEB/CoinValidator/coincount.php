<?php extract($_POST); ?>
<?php 
    if (empty($name)){
        header("Location: index.php?error=<p>Your name is required</p>"); die();
    }
    
    if (is_numeric($name)){
        header("Location: index.php?error=<p>Your name can't contain number(s)</p>"); die();
    }
    
    if (!empty($pennies) && !is_numeric($pennies)){
        header("Location: index.php?error=<p>put number in pennies</p>"); die();
    }

    if (!is_numeric($nickels) && !empty($nickels)){
        header("Location: index.php?error=<p>put number in nickels</p>"); die();
    }

    if (!is_numeric($dimes) && !empty($dimes)){
        header("Location: index.php?error=<p>put number in dimes</p>"); die();
    }
    
    if (!is_numeric($quarters) && !empty($quarters)){
        header("Location: index.php?error=<p>put number in quarters</p>"); die();
    }
    
    if (!is_numeric($oneDollar) && !empty($oneDollar)){
        header("Location: index.php?error=<p>put number in One Dollar</p>"); die();
    }
    
    if (!is_numeric($twoDollar) && !empty($twoDollar)){
        header("Location: index.php?error=<p>put number in Two Dollar</p>"); die();
    }
?>

<?php include("include/header2.php"); ?>

    <div class="container">
        <div class="row">
            <div class="col-xs-6 col-sm-3">Pennies:</div>
            <div class="col-xs-6 col-sm-3">
                <?php 
                if (!is_numeric($pennies)){
                    $pennies = '0';
                    echo $pennies;
                }else
                    echo $pennies;
                ?>
            </div>
            <div class="clearfix visible-xs"></div>
            <div class="col-xs-6 col-sm-3">Nickels:</div>
            <div class="col-xs-6 col-sm-3">
                <?php 
                if (!is_numeric($nickels)){
                    $nickels = '0';
                    echo $nickels;
                }else
                    echo $nickels;
                ?>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-6 col-sm-3">Dimes:</div>
            <div class="col-xs-6 col-sm-3">
                <?php 
                if (!is_numeric($dimes)){
                    $dimes ='0';
                    echo $dimes;
                }else
                    echo $dimes;
                ?>
            </div>
            <div class="clearfix visible-xs"></div>
            <div class="col-xs-6 col-sm-3">Quarters:</div>
            <div class="col-xs-6 col-sm-3">
                <?php 
                if (!is_numeric($quarters)){
                    $quarters ='0';
                    echo $quarters;
                }else
                    echo $quarters;
                ?>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-6 col-sm-3">Dollar Coins:</div>
            <div class="col-xs-6 col-sm-3">
                <?php 
                if (!is_numeric($oneDollar)){
                    $oneDollar ='0';
                    echo $oneDollar;
                }else
                    echo $oneDollar;
                ?>
            </div>
            <div class="clearfix visible-xs"></div>
            <div class="col-xs-6 col-sm-3">Two Dollar Coins:</div>
            <div class="col-xs-6 col-sm-3">
                <?php 
                if (!is_numeric($twoDollar)){
                    $twoDollar ='0';
                    echo $twoDollar;
                }else
                    echo $twoDollar;
                ?>
            </div>
        </div>
        <h1><?php echo $name ?>, you therefore have:</h1>
        <div class="row">
            <div class="col-xs-6 col-sm-3">Total Cents:</div>
            <div class="col-xs-6 col-sm-3">
                <?php
                    $cent = array($pennies, $nickels*5, $dimes*10, $quarters*25, $oneDollar*100, $twoDollar*200);
                    echo array_sum($cent);
                ?>
            </div>
            <div class="clearfix visible-xs"></div>
            <div class="col-xs-6 col-sm-3">Total Dollars:</div>
            <div class="col-xs-6 col-sm-3">
                <?php
                    $dollar = array($pennies*0.01, $nickels*0.05, $dimes*0.1, $quarters*0.25, $oneDollar, $twoDollar*2);
                    echo array_sum($dollar);
                ?>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <a href="index.php" class="btn btn-success" role="button">Back to home page</a>
            </div>
        </div>
    </div>




<?php include("include/footer.php"); ?>