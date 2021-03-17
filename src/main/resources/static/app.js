        var username;
        getList();
        getListBasketCab();
        getListUser();
           function rel(){document.reload(); }

                            /*Функция авторизации маг игрушек*/
                var baskets = [];
                var cnt = 0;
                function addBasket(val) {

                     let data = {
                             username: username,
                             toyid: val,
                     };


                     $.post('/addBasket', data, function(result) {

                        console.log(result);
                        cnt=result;
                        document.getElementById("cnt").innerHTML = cnt;

                     });

                }
        /*********************************************************************************************/


                            /*Функция показывает список игрушек и */

                    function getList() {

                       $.ajax({url: "/list", success: function(result) {
                       $("#table2 tbody").empty();
                           for(let i=0; i<result.length; i++) {
                                    addRow(result[i]);


                           }
                        }});
                    }

                    function getList_01() {

                       $.ajax({url: "/list", success: function(result) {
                    $("#table2 tbody").empty();
                           for(let i=0; i<result.length; i++) {
                               if (result[i].kat == '555') {
                                    addRow(result[i]);
                               }
                           }
                        }});
                    }
                    function getList_02() {

                       $.ajax({url: "/list", success: function(result) {
                     $("#table2 tbody").empty();
                           for(let i=0; i<result.length; i++) {
                               if (result[i].kat == '444') {
                                    addRow(result[i]);
                               }
                           }
                        }});
                    }
                    function getList_03() {
                       $.ajax({url: "/list", success: function(result) {

                        $("#table2 tbody").empty();
                           for(let i=0; i<result.length; i++) {
                               if (result[i].kat == '888') {
                                    addRow(result[i]);
                               }
                           }
                        }});
                    }
                    function addRow(toys) {
                        let markup =        '<tr>'+
                                                 '<td>'+toys.id+'</td>'+
                                                 '<td>'+toys.nametoys+'</td>'+
                                                 '<td>'+toys.company+'</td>'+
                                                 '<td>'+toys.price+'</td>'+
                                                   "<td>" +
                                                           '<button onclick="addBasket('+toys.id+')" id="updateBtn">добавить в_корзину</button>'+
                                                           "</button>" +
                                                           "</td>" +
                                             '</tr>';

                        $("#table2 tbody").append(markup);

                    }

        /*********************************************************************************************/


                            /*Функция показывает список игрушек в корзине */

        function getListBasketCab() {
           $.ajax({url: "/listBasketCab", success: function(result) {
               for(let i=0; i<result.length; i++) {
                        addRow2(result[i]);location.reload(id)
               }
            }});

        function addRow2(Basket) {
            let markup4 =        '<tr>'+
                                     '<td>'+Basket.id+'</td>'+
                                     '<td>'+Basket.username+'</td>'+
                                     '<td>'+Basket.toyid+'</td>'+
                                       "<td>" +
                                               '<button onclick="addBasketBy()" id="up">Купить</button>'+
                                               '<button onclick="deleteRow('+Basket.id+')">удалить</button>'+
                                       "</td>" +
                                 '</tr>';
            $("#table3 tbody").append(markup4);

                };

        }
    /*********************************************************************************************/


                        /*Функция удаляет из корзины игрушки по ID*/

        function deleteRow(id) {
        $.ajax({url: "/deleteBasket/"+id, type: 'DELETE', success: function(result){
        location.reload(id);
          }});
        }
    /************************************************************************************************/


$(document ).ready(function() {
    console.log( "ready!" );
              var modal = document.getElementById("myModal");
              var btn = document.getElementById("myBtn");
              var span = document.getElementsByClassName("close")[0];
              span.onclick = function() {
                    modal.style.display = "none";
              }

             var btnSave = document.getElementById("save");
              btnSave.onclick = function() {
                authOrRegister( "pwd","email", "/register");
              }

              var openCabinet = document.getElementById("openCabinet");
                openCabinet.onclick = function() {


                    authOrRegister("pwd1", "email1", "/auth", modal);
                }

});

function authOrRegister(inp1, inp2, url, modal) {
     var data = {
         pwd: $('input#'+inp1).val(),
         email: $('input#'+inp2).val()
     };


     $.ajax({
         url: url,
         type: 'POST',
         data: data,
         async: false,
         success: function(res) {
            console.log("result", res);
                alert(res.description);
                modal.style.display = "none";
                document.getElementById("userEmail").innerHTML = res.user.email;
                username = res.user.email;

        }
     });
}



        function getListUser() {
           $.ajax({url: "/getListregister", success: function(result) {
               for(let i=0; i<result.length; i++) {
                        addRo7(result[i]);

               }

            }});
        }
        function addRo7(user) {
            let markup7 =        '<tr>'+
                                     '<td>'+user.id+'</td>'+
                                     '<td>'+user.email+'</td>'+
                                     '<td>'+user.pwd+'</td>'+
                                     '</tr>';
            $("#table5 tbody").append(markup7);

        }