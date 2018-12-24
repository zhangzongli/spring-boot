function randomRecipe() {
    $.ajax({
        url: "/api/random-recipe",
        type: "get",
        async: false,
        success: function (data) {
            $("#recipe—div").css("display", "block");
            $("#recipe-name").html(data);
        }
    })
}