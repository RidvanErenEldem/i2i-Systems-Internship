package com.eldem.akkaExample;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ActorSystem create = ActorSystem.create("actor-system");
        ActorRef mainActor = create.actorOf(Props.create(MainActor.class));
        ActorRef secondActor = create.actorOf(Props.create(SecondaryActor.class));
        
        mainActor.tell(("Ana aktör mesajı"), Actor.noSender());
        secondActor.tell("Ana aktörden ikinci aktöre mesaj\n", mainActor);
        secondActor.tell("İkinci aktör mesaj\n", Actor.noSender());
    }
}
