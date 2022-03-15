        @Override
        public int compareTo(Node annen){
        
            if (annen.data instanceof Integer){

                if ((int) data > (int) annen.data){
                    return 1;}
                else if ((int) data < (int) annen.data){
                    return -1;}
                return 0;
            }

            else if (annen.data instanceof String){


                String foerste = (String) data;
                String andre = (String) annen.data;
                
                return foerste.compareToIgnoreCase(andre);
                
                
            }
        }
