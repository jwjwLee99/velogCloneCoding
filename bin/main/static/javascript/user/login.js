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

    $(".loginSubmit").click(function () {
        if (!$("#userid").val() || !$("#userpw").val()) {
            alert('아이디와 비번을 정확히 입력하세요')
        } else {
            toLogin($("#userid").val())
        }
    })

    function toLogin(userid) {
        $.get("/api/user/login/" + userid, function (response) {
            let item = response.data;
            if (!item) {
                alert("아이디 또는 비밀번호를 잘못 입력했습니다. \n" +
                    "입력하신 내용을 확인해주세요")
            } else if (item.userid === $("#userid").val() && item.userpw !== $("#userpw").val()) {
                alert('비밀번호를 잘못 입력했습니다.')
            } else if (item.userid === $("#userid").val() && item.userpw === $("#userpw").val()) {
                location.href = "/" + userid;
            }
        })
    }
})

