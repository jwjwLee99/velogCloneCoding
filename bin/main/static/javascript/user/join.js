$(() => {
    $(".etcInput").focusin(function(){
        $(this).next('.focus-border').css("visibility", "visible").animate({
            width: "99%"
        }, 400)
    })
    $(".etcInput").focusout(function(){
        $(this).next('.focus-border').css("visibility", "hidden").animate({
            width: "0"
        }, 400)
    })

    let isReplyAggree = true;
    $(".replyAlims").click(function(){
        if(isReplyAggree){
            $(this).css({
                background: "#12B886"
            });
            $(this).children(".circle").animate({
                left: "1.325rem"
            }, 100)
            isReplyAggree = false
        }else {
            $(this).css({
                background: "rgb(134, 142, 150)"
            });
            $(this).children(".circle").animate({
                left: "0"
            }, 100)
            isReplyAggree = true
        }
    })

    let isUpdateAggree = true
    $(".updateAlims").click(function(){
        if(isUpdateAggree){
            $(this).css({
                background: "#12B886"
            });
            $(this).children(".circle").animate({
                left: "1.325rem"
            }, 100)
            isUpdateAggree = false
        }else {
            $(this).css({
                background: "rgb(134, 142, 150)"
            });
            $(this).children(".circle").animate({
                left: "0"
            }, 100)
            isUpdateAggree = true
        }
    })
})