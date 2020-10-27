    //	
    //acts as in memory DAO
    var DataService = function() { //setting up object
        var self = this;


        // const itemList = [{   -->> hardcode data to begin
        //     id: 1,
        //     name: 'MilkeyWay',
        //     price: 1.50,
        //     quantity: 10
        // }];


        ////////////////////////////
        //////Data manipulation



        //Ajax either returns success or failure.
        self.getItems = function(callback, errorFunc) {
            $.ajax({
                url: 'http://tsg-vending.herokuapp.com/items',
                method: 'GET',
                success: callback,
                error: errorFunc
            });
            //     setTimeout(function() {
            //         callback(itemList);
            //     }, 300); //waits for few
            // }
        }

        self.vendItems = function(amount, itemId, callback, errorFunc) {
            $.ajax({
                url: 'http://tsg-vending.herokuapp.com/money/' + amount + '/item/' + itemId,
                method: 'POST',
                success: callback,
                error: errorFunc
            });
        }
    }