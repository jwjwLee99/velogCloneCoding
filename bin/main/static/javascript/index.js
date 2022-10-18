// index.js

$(function() {
    // 트렌딩 최신 active활성화
    let trandingBtn = $(".tranding")
    let latestBtn = $(".latest")

    let main1 = $(".main-list")
    let main2 = $(".main-list2")

    let underline = $(".underLine")

    let rightMenuBtn = $(".recentSelect")

    trandingBtn.click(()=> {
        trandingBtn.addClass("active")
        latestBtn.removeClass("active")
        main1.css("display", "flex")
        main2.css("display", "none")
        rightMenuBtn.css("display", "flex")
        underline.animate({
            left: "0%"
        }, 300)
    })

    latestBtn.click(()=> {
        trandingBtn.removeClass("active")
        latestBtn.addClass("active")
        main1.css("display", "none")
        main2.css("display", "flex")
        rightMenuBtn.css("display", "none")
        underline.animate({
            left: "50%"
        }, 300)
    })

    
    let today =  $(".today")
    let week = $(".week")
    let month = $(".month")
    let year = $(".year")

    $(".recentSelect span").text($(".active-list").text())

    $(".today").click(function(){
        $(".today").addClass("active-list")
        week.removeClass("active-list")
        month.removeClass("active-list")
        year.removeClass("active-list")
        $(".recentSelect span").text("오늘")
    })

    $(".week").click(function(){
        $(".week").addClass("active-list")
        today.removeClass("active-list")
        month.removeClass("active-list")
        year.removeClass("active-list")
        $(".recentSelect span").text("이번 주")
    })

    $(".month").click(function(){
        $(".month").addClass("active-list")
        week.removeClass("active-list")
        today.removeClass("active-list")
        year.removeClass("active-list")
        $(".recentSelect span").text("이번 달")
    })

    $(".year").click(function(){
        $(".year").addClass("active-list")
        week.removeClass("active-list")
        month.removeClass("active-list")
        today.removeClass("active-list")
        $(".recentSelect span").text("올해")
    })

})
