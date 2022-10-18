$(() => {
    let likePostBtn = $(".likePost")
    let recentPostBtn = $(".recentPost")

    let main1 = $(".mainPost")
    let main2 = $(".mainPost2")

    let underline = $(".underLine")

    likePostBtn.click(() => {
        likePostBtn.addClass("active")
        recentPostBtn.removeClass("active")
        main1.css("display", "flex")
        main2.css("display", "none")
        underline.animate({
            right: "50%"
        }, 300)
    })

    recentPostBtn.click(() => {
        likePostBtn.removeClass("active")
        recentPostBtn.addClass("active")
        main1.css("display", "none")
        main2.css("display", "flex")
        underline.animate({
            right: "0%"
        }, 300)
    })
})
