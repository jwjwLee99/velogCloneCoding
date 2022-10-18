// login.js
/*
main1 = account
main2 = login
main3 = search
main4 = findpw
*/

$(() => {

    let main2 = $(".login")
    let main3 = $(".search")
    let main4 = $(".findpw")

    let loginBtn = $(".alink")

    loginBtn.click(() => {
        accountBtn.removeClass("active")
        loginBtn.addClass("active")
        main1.css("display", "none")
        main2.css("display", "flex")
    })

    let idBtn = $(".find-id")
    let cancleBtn = $(".loginBtn")

    idBtn.click(() => {
        idBtn.addClass("active")
        cancleBtn.removeClass("active")
        main3.css("display", "flex")
        main2.css("display", "none")
    })

    cancleBtn.click(() => {
        idBtn.removeClass("active")
        cancleBtn.addClass("active")
        main3.css("display", "none")
        main2.css("display", "flex")
    })

    let pwBtn = $(".find-pw")
    let cancleBtn2 = $(".loginBtn2")

    pwBtn.click(() => {
        pwBtn.addClass("active")
        cancleBtn2.removeClass("active")
        main4.css("display", "flex")
        main2.css("display", "none")
    })  

    cancleBtn2.click(() => {
        pwBtn.removeClass("active")
        cancleBtn2.addClass("active")
        main4.css("display", "none")
        main2.css("display", "flex")
    })

    let findpwBtn = $(".pwfind")

    findpwBtn.click(() => {
        findpwBtn.addClass("active")
        main4.css("display", "flex")
    })

    let loginBtn2 = $(".loginBtn2")

    loginBtn2.click(() => {
        loginBtn2.addClass("active")
        main2.css("display", "flex")
        main4.css("display", "none")
        main3.css("display", "none")
    })

    let pwaccountBtn = $(".pwaccount")

    pwaccountBtn.click(() => {
        pwaccountBtn.addClass("active")
        main1.css("display", "flex")
        main4.css("display", "none")
        main3.css("display", "none")
    })

})

