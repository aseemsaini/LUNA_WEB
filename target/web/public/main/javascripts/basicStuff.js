if (window.console) {
  console.log("Running Js!");

  $("#randomText").click(function() {
    $("#random").load("/random")
  });

const stringText = document.getElementById("randomStringText");
stringText.onclick = async () => {
  try {
    const lengthInput = document.getElementById("lengthValue");
    const url = "/randomString/" + lengthInput.value;
    console.log(url);

    const response = await fetch(url);
    if (!response.ok) {
      throw new Error("Request failed with status " + response.status);
    }

    const responseText = await response.text();
    const randomString = document.getElementById("randomString");
    randomString.innerHTML = responseText;
  } catch (error) {
    console.error("An error occurred:", error);
  }
};


}
