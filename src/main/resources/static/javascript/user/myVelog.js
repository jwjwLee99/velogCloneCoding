$(function() {
    // 글 시리즈 소개
    // 나중에 글 시리즈 소개 display 변경
    // 태그 목록 display 설정하기 (내일)
    
    let firstMenuBtn = $(".firstMenu")
    let secondMenuBtn = $(".secondMenu")
    let thirdMenuBtn = $(".thirdMenu")
    let seriesMain = $(".seriesDiv")
    let postMain = $(".postDiv")
    let SearchBar = $(".myVelogSearchBar")
    let tag = $(".tagPosition")
    let introduceMain = $(".introduceNoneDisplay")

    let UnderBar = $(".middleMenuUnderBar")

    firstMenuBtn.click(() => {
        firstMenuBtn.addClass("active")
        secondMenuBtn.removeClass("active")
        thirdMenuBtn.removeClass("active")
        postMain.css("display", "block")
        seriesMain.css("display", "none")
        introduceMain.css("display", "none")
        tag.css("display", "flex")
        SearchBar.css("display", "flex")
        $(".introBox").css("display", "none")
        UnderBar.animate({
            left: "0%"
        }, 300)
    })

    secondMenuBtn.click(() => {
        secondMenuBtn.addClass("active")
        firstMenuBtn.removeClass("active")
        thirdMenuBtn.removeClass("active")
        postMain.css("display", "none")
        seriesMain.css("display", "flex")
        introduceMain.css("display", "none")
        tag.css("display", "none")
        SearchBar.css("display", "none")
        $(".introBox").css("display", "none")
        UnderBar.animate({
            left: "33%"
        }, 300)
    })

    thirdMenuBtn.click(() => {
        thirdMenuBtn.addClass("active")
        secondMenuBtn.removeClass("active")
        firstMenuBtn.removeClass("active")
        postMain.css("display", "none")
        seriesMain.css("display", "none")
        introduceMain.css("display", "flex")
        tag.css("display", "none")
        SearchBar.css("display", "none")
        $(".introBox").css("display", "none")
        UnderBar.animate({
            left: "66%"
        }, 300)
    })

    // 소개글 작성할 때 나오는거
    $(".introduceNoneDisplay button").click(() => {
        introduceMain.css("display", "none")
        $(".introBox").css("display", "flex")
    })
})

// 소개 글 추가 textarea height 자동 조절 js

function resize(obj) {
    obj.style.height = (12+obj.scrollHeight)+"px";
}
  