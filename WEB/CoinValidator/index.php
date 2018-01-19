<?php include("include/header.php"); ?>
<?php extract($_POST); ?>
<?php extract($_GET); ?>

<div class="container">
    <h3>Please enter your coin count:</h3>
    
    <form class="form-horizontal" action="coincount.php" method="post">
        <div class="row">
            <div class="col-xs-offset-3 col-xs-9">
                <?php echo $error; ?>
            </div>
        </div>
        <div class="form-group required">
            <label class="control-label col-xs-3" for="text">Your name:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="text" placeholder="Enter your name" name="name" size="30" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-xs-3" for="number">Pennies (1 &cent):</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="text" placeholder="Enter Pennies" name="pennies" size="30" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-xs-3" for="text">Nickels (5 &cent):</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="text" placeholder="Enter nickels" name="nickels" size="30" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-xs-3" for="text">Dimes (10 &cent):</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="text" placeholder="Enter dimes" name="dimes" size="30" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-xs-3" for="text">Quarters (25 &cent):</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="text" placeholder="Enter quarters" name="quarters" size="30" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-xs-3" for="text">1 Dollar Coins:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="text" placeholder="Enter one dollar coins" name="oneDollar" size="30" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-xs-3" for="text">2 Dollar Coins:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="text" placeholder="Enter two dollar coins" name="twoDollar" size="30" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-4">
                <button type="submit" name="submit" class="btn btn-primary">Calculate Coins</button>
            </div>
            <div class="col-xs-offset-1 col-xs-5">
                <button type="reset" name="reset" class="btn btn-primary">Clear form</button>
            </div>
        </div>
    </form>
</div>


<?php include("include/footer.php"); ?>
