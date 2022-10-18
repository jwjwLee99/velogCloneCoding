$(() => {
    var input = document.querySelector('.basic'),
        tagify = new Tagify(input, {
        })
    tagify.addEmptyTag()
})

$(() => {
    let main1 = $(".wrapper")
    let main2 = $(".cPEGOG")

    let publicationBtn = $(".jYsOEX")
    let cancleBtn = $(".bitsEI")


    publicationBtn.click(() => {
        cancleBtn.removeClass("active")
        publicationBtn.addClass("active")
        main1.css("display", "none")
        main2.css("display", "flex")
    })

    cancleBtn.click(() => {
        cancleBtn.removeClass("active")
        publicationBtn.addClass("active")
        main1.css("display", "block")
        main2.css("display", "none")
    })
})

$(() => {
    document.getElementById("b2").onclick = function () {
        document.getElementById("b1").className = "bXGcfH";
        document.getElementById("b2").className = "yAuOg";
    }

    document.getElementById("b1").onclick = function () {
        document.getElementById("b1").className = "yAuOg";
        document.getElementById("b2").className = "bXGcfH";
    }
})

$(() => {
    let main1 = $(".seriespage")
    let main2 = $(".basicpage")

    document.getElementById("a0").onclick = function () {
        document.getElementById("c1").className = "seriespage";
        main1.css("display", "flex")
        main2.css("display", "none")
    }

    document.getElementById("a1").onclick = function () {
        document.getElementById("c2").className = "basicpage";
        main1.css("display", "none")
        main2.css("display", "contents")
    }
})

$(document).ready(function () {
    $('#textcount').on('keyup', function () {
        $('#test_cnt').html("" + $(this).val().length + "/150");

        if ($(this).val().length > 150) {
            $(this).val($(this).val().substring(0, 150));
            $('#test_cnt').html("150/150");
        }
    });
});

$(() => {

    let seriesnameBtn = $(".fIsQRt")
    let seriesnamecancleBtn = $(".icODNG")


    seriesnameBtn.click(() => {
        $(".cWIEIO").slideDown(25);
        $(".fmmwfE").fadeIn(500);
        //main2.css("display", "block")
    })

    seriesnamecancleBtn.click(() => {
        $(".fmmwfE").fadeOut(500);
        $(".cWIEIO").slideUp(550);
        //main2.css("display", "none")

    })
})

    $(() => {

        window.onload = function () {
            document.getElementById("preview").onclick = innerText;
        }
        function innerText() {
            const name = document.getElementById('name').value;
            document.getElementById('result').innerText = name;
        }
    })

    $(() => {
        const browseBtn = document.querySelector('.uFBYd');
        const realInput = document.querySelector('#real-input');

        browseBtn.addEventListener('click', () => {
            realInput.click();
        });

        const reader = new FileReader();

        reader.onload = (readerEvent) => {
            document.querySelector("#imagePreview").setAttribute("src", readerEvent.target.result);
            //파일을 읽는 이벤트가 발생하면 img_section의 src 속성을 readerEvent의 결과물로 대체함
        };

        document.querySelector("#real-input").addEventListener("change", (changeEvent) => {
            //upload_file 에 이벤트리스너를 장착

            const imgFile = changeEvent.target.files[0];
            reader.readAsDataURL(imgFile);

        })
    })

    $(() =>{
        let ssumnailBtn = $(".uFBYd")

        ssumnailBtn.click(() => {
            $(".uFBYd").css("display", "none")
            $(".imagepreview").css("display", "flex")
            //main2.css("display", "block")
        })
    })
    /*
    let subToggle = true;
    $(".fIsQRt").click(() => {
        if (subToggle) {
            $(".cWIEIO").slideDown(2000);
            $(".fmmwfE").fadeIn(1000);
        } else {
            $(".fmmwfE").fadeOut(1000);
            $(".cWIEIO").slideUp(1000); 
        }
        subToggle = !subToggle;
    });
    */
/*
$(() => {
    let subToggle = true;
    $(".fIsQRt").click(() => {
        if (subToggle) {
            $(".cWIEIO").slideDown(2000);
            $(".fmmwfE").fadeIn(1000);
        } else {
            $(".fmmwfE").fadeOut(1000);
            $(".cWIEIO").slideUp(1000);

        }
        subToggle = !subToggle;
    });
})
*/
