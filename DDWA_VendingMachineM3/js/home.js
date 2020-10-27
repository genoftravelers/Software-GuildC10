let ds = new DataService();

// const itemList = [{
//     id: 1,
//     name: 'MilkeyWay',
//     price: 1.50,
//     quantity: 10
// }];

var totalAmount = 0;
var selectedItem;
var index = 1;

function formatItemArea(item) {
    let itemPlace = `<div class="box-item" data-index="${index}" data-idnumber="${item.id}"> <span id="number" >` + index + `</span><br/>${item.name}<br/>Price: ${item.price.toFixed(2)}<br/><br/>Quantity: ${item.quantity}</div>`
    index++;
    return itemPlace;
}

//goes through loop to create new Items each time refresehed.
function refreshArea(items) { //CLICK
    index = 1;
    // ds.getItems(refreshArea, alert)
    let itemArea = $("#itemArea");
    itemArea.empty();
    for (let i = 0; i < items.length; i++) {
        const item = items[i];
        $(itemArea).append(formatItemArea(item));
    }

}

//gets the idnumber from the data and gives value of the var selectedItem.
function selectItem() { //CLICK
    // $("#msg").val('');
    // alert("hey");
    selectedItem = $(this).data('idnumber');
    index = $(this).data('index');
    // console.log(selectedItem);
    $("#itemId").val(index);
}

//Displays the change returned to the user in the change box
// in the format of how many quarter, dime, nickel, or penny.
//Ex: $0.82 change would be: "3 quarters, 1 nickel, 2 pennies.

function returnChange(money) { //CLICK
    // alert("return change");
    let quarter = money.quarters;
    let dime = money.dimes;
    let nickel = money.nickels;
    let penny = money.pennies;
    let messageForChange = '';



    if (quarter > 0) {
        messageForChange += quarter + ' quarters,';
    }

    if (dime > 0) {
        messageForChange += dime + ' dimes,';
    }

    if (nickel > 0) {
        messageForChange += nickel + ' nickels,';
    }

    if (penny > 0) {
        messageForChange += penny + ' pennies';
    }
    //Show the user how much change is returned

    $("#change").val(messageForChange);
    console.log(messageForChange);
    console.log(money);
}

function changeButtonClicked() { //CLICK
    // alert("button clicked should reset");
    // $("#changeButton").val('');
    $("#fullAmount").val('0.00');
    $("#msg").val("");
    totalAmount = 0;


}

function purchaseItem() { // takes in four parameters     //CLICK
    // alert("purshase works?");
    index = $("#itemId").val();
    // console.log(totalAmount);
    // console.log(selectedItem);

    if (index == '') {
        $("#msg").val("Please make a selection.");
    } else {
        ds.vendItems(totalAmount, selectedItem, returnChange, errorFunc);
        //Once the purchase is successful , refresh the item list , 

        ds.getItems(refreshArea, errorFunc);

        //make the selected item empty
        $("#itemId").val('');

        //totalAmount should be reset 
        /* your code goes here*/
        $("#fullAmount").val('$0.00');
        totalAmount = 0;

        //display Thank you!!!
        $("#msg").val("Thank You!!");

    }
}

function addAdollar(e) { //ALL CLICK
    totalAmount += 1;
    $("#fullAmount").val(totalAmount.toFixed(2)); //ROUNDS UP THE DECIMALS

}

function addAquarter(e) {
    totalAmount += .25;
    $("#fullAmount").val(totalAmount.toFixed(2));

}

function addAdime(e) {
    totalAmount += .1;
    $("#fullAmount").val(totalAmount.toFixed(2));
}

function addAnickle(e) {
    totalAmount += .05;
    $("#fullAmount").val(totalAmount.toFixed(2));
}


//the data coming in has JSON error
function errorFunc(data) { //
    $("#msg").val(data.responseJSON.message);
}

$(document).ready(function() {
    // alert("I am here");

    ds.getItems(refreshArea, errorFunc); //will get error msg when unsuccessful.

    // refreshArea(ds.getItems());
    $(document).on('click', '#addDollar', addAdollar);

    $(document).on('click', '#addQuarter', addAquarter);

    $(document).on('click', '#addDime', addAdime);

    $(document).on('click', '#addNickle', addAnickle);

    // $(document).on('click', '#userMessage', );

    $(document).on('click', '.box-item', selectItem); //when clicked on boxitem, it should run the selectItem func.
    $(document).on('click', '#makePurchase', purchaseItem); // -----> NEW
    $(document).on('click', '#changeButton', returnChange);
    $(Document).on('click', '#changeButton', changeButtonClicked);

})