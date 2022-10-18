// header.js
$(() => {
    let previousScroll = 0;
    let sh = $("#scrollMoveHeader");
    
    $(window).scroll(function() {
        let currentScroll = $(this).scrollTop();
        let scrollTop = $(window).scrollTop();
    
        if(currentScroll < previousScroll){
            sh.slideDown("fast")
        }else {
            sh.slideUp("fast")
        }
        if(scrollTop == 0){
            sh.fadeOut(1)
        }
        previousScroll = currentScroll;
    })
    $("nav div div.userSection img").mouseover(()=> {
        $("nav div div.userSection > svg").css("color", "#212529")
    })
    $("nav div div.userSection img").mouseout(()=> {
        $("nav div div.userSection > svg").css("color", "#868E96")
    })

    $(".recentSelect").click(() => {
        $(".rightMenu").fadeIn(200)
        $(".background").fadeIn(200)
    })
    // 여기 다시 해보기
    $(".recentMenu ul li").click(() => {
        $(".rightMenu").fadeOut(200)
    })
    $(".background").click(() => {
        $(".rightMenu").fadeOut(200)
        $(".background").fadeOut(200)
    })

    // 오른쪽 설정 메뉴
    $(".rightSection").click(() => {
        $(".etcMenuBox").fadeIn(200)
        $(".background").fadeIn(200)
    })
    
    $(".etcMenuBox ul li").click(() => {
        $(".etcMenuBox").fadeOut(200)
    })
    
    $(".background").click(() => {
        $(".etcMenuBox").fadeOut(200)
        $(".background").fadeOut(200)
    })

    // recentSelect 메뉴목록 active 활성화
})