package JosephusProject;

/**
 *
 * @author MCON264
 */
public class GCLL<T>
{

    private Node first = null;

    /**
     * creates node for list to be created. Each node has info and a 'next' pointer
     * to the next node that is created.
     * @param <T>
     */
//<editor-fold defaultstate="collapsed" desc="Node">
    private class Node<T>
    {

        private T info;
        private Node<T> next;

        private Node(T info)
        {
            this.info = info;
            next = null;
        }

    }

//</editor-fold>
    /**
     * once object list is created, adds new node to list and sets it as first
     * node.
     * @param element
     */
    public void add(T element)
    {
        Node node = new Node(element);

        if (first == null)
        {
            first = node;
            first.next = first;
        }
        else
        {
            node.next = first.next;
            first.next = node;
        }
    }
    /**
     *
     * @param element
     * @return boolean true if element is found
     */
    public boolean find(T element)
    {
        boolean retVal = false;
        Node curr = first;
        if (curr != null)
        {
            do
            {
                curr = curr.next;
                if (curr.info.equals(element))
                {
                    retVal = true;
                    break;
                }
            } while (curr != first);

        }
        return retVal;
    }

    /**
     *
     * @return first element of the list
     */
    public T getFirst()
    {
        T element = null;
        if (first != null)
        {
            element = (T) first.info;
        }
        return element;
    }
    /**
     * looks for given element in list and if it does exist, it sets the existing
     * element's node to equal the next node, essentially removing the current node
     * element.
     * @param element
     * @return true if the element put into the parameter is successfully removed
     */
    public boolean remove(T element)
    {
        boolean retVal = false; //if element is removed
        if (find(element)) // if element exists in the list
        {
            Node curr = first;
            //let's do it ourselves first before looking at what's wrong with the original
            while (!retVal) //keep doing everything in this loop until retVal is equal to true. In other words, until we've succeeded in removing
            {
                if (curr.next.info.equals(element)) //here it is
                {
                    curr.next = curr.next.next; //curr is dropping its next to take the one after that - this is the actual removing
                    retVal = true; //found  it! we can stop now
                }
                else
                {
                    curr = curr.next;
                }
            } // back up to while

            //this is the original way.
            //do
            //{
            //curr = curr.next;
            //if (curr.next.info.equals(element))
            //{
            //    curr.next = curr.next.next;
            //    retVal = true;
            //    break;
            //}
            // } while (true);

        }
        return retVal; //in the while, retVal was true, so now we're done! Yay!
    }

    /**
     * checks list for count, the input element. if count is higher in the list
     * than the first element, it moves it down to the first element.
     * @param count
     */
    public void advance(int count)
    {
        if (count > 0)
        {
            for (int move = 0; move < count; ++move)
            {
                first = first.next;
            }
        }
    }

    @Override
    public String toString()
    {
        String rV = "first->";
        if (first != null)
        {
            Node<T> curr = first;
            while (curr.next != first)
            {
                rV += ("|" + curr.info.toString() + "|->");
                curr = curr.next;
            }
            rV += ("|" + curr.info.toString() + "|");
        }
        return rV;
    }
}

