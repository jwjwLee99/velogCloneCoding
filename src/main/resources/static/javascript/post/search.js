$(() => {
  let searchInput = $(".searchInput");
  let searchLine = $(".search-line")
  searchInput.focus(function() {
    console.log("focus")
    searchLine.css({
      "border" : "1px solid #000"
    })
  })
  searchInput.blur(()=> {
    searchLine.css({
      "border" : "1px solid #ADB5BD"
    })
  })
})