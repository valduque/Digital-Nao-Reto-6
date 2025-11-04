const box = document.getElementById("updates");
const ws = new WebSocket("ws://" + location.host + "/price-updates");

ws.onmessage = e => {
const div = document.createElement("div");
div.textContent = e.data;
box.appendChild(div);
};
