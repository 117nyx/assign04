package assign06;

import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class simulates a web browsers ability to visit previous and next web pages using
 * two stacks backed by linked list and a list.
 * Authors: Jonathan Kerr and Eden Harvey
 */
public class WebBrowser<URL> {
    private LinkedListStack<URL> back;
    private LinkedListStack<URL> forward;

    private URL current;

    /**
     *This constructor creates a new web browser
     * with no previously-visited webpages and no webpages to visit next.
     */
    public WebBrowser(){
        back = new LinkedListStack<URL>();
        forward = new LinkedListStack<URL>();
    }

    /**
     * This constructor creates a new web browser with a preloaded history of visited webpages,
     * given as a list of URL objects. The first webpage in the list is the "current" webpage visited,
     * and the remaining webpages are ordered from most recently visited to least recently visited.
     * @param history
     */
    public WebBrowser(SinglyLinkedList<URL> history){
        back = new LinkedListStack<>();
        current = history.getFirst();
        for(int i=history.size();i>=0;i--){
            back.push(history.get(i));
        }
        forward = new LinkedListStack<URL>();
    }

    /**
     * This method simulates visiting a webpage, given as a URL.
     * Note that calling this method should clear the forward button stack,
     * since there is no URL to visit next.
     * @param webpage
     */
    public void visit(URL webpage){
        forward.clear();
        back.push(current);
        current=webpage;
    }

    /**
     * This method simulates using the back button, returning the URL visited.
     * NoSuchElementException is thrown if there is no previously-visited URL.
     * @return
     * @throws NoSuchElementException
     */
    public URL back() throws NoSuchElementException {
        if(back.isEmpty()){
            throw new NoSuchElementException();
        }
        forward.push(current);
        current=back.pop();
        return current;
    }

    /**
     * This method simulates using the forward button, returning the URL visited.
     * NoSuchElementException is thrown if there is no URL to visit next.
     * @return
     * @throws NoSuchElementException
     */
    public URL forward() throws NoSuchElementException{
        if(forward.isEmpty()){
            throw new NoSuchElementException();
        }
        back.push(current);
        current=forward.pop();
        return current;
    }

    /**
     * This method generates a history of URLs visited, as a list of URL objects
     * ordered from most recently visited to least recently visited (including the "current" webpage visited),
     * without altering subsequent behavior of this web browser. "Forward" URLs are not included.
     * The behavior of the method must be O(N), where N is the number of URLs.
     * @return
     */
    public SinglyLinkedList<URL> history(){
        SinglyLinkedList hist = new SinglyLinkedList();
        hist.insertFirst(current);
        ArrayList<URL> temp = new ArrayList<URL>();
        while(!back.isEmpty())
            temp.add(back.pop());
        for(int i= temp.size() - 1;i>=0;i++){
            hist.insert(i,temp.get(i-1));
            back.push(temp.get(temp.size()-i));
        }
        return hist;
    }
}
