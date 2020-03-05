using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using SimpleTCP;

public class Server : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        print("Hello world!");
        var server = new SimpleTcpServer().Start(5000);
        server.DataReceived += (sender, msg) => {
                msg.Reply("Content-Type: text/plain\n\nHello from my web server!"); 
                };
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
