/*
 * Asteroid Collision - Given a list representing asteroids, return a list of the resulting asteroids
 * after all collisions. Two asteroids can collide if they have opposite signs, and the asteroid with
 * a larger value will persist. Two asteroids that collide with the same value will both be
 * destroyed.
 * 
 * If the current asteroid has a positive value, we simply push it to a stack. If the asteroid is
 * negative, we need to check for cases. We need to check if there is a collision. If there isn't,
 * then we push it to the stack. If there is, we check whether the current asteroid is destroyed,
 * if both asteroids are destroyed, or if the other asteroid is detroyed.
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res;
        
        for (int a : asteroids) {
            if (a > 0)
                stack.push(a);
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                    stack.pop();
                }
                
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(a);
                else if (a + stack.peek() == 0)
                    stack.pop();
            }
        }
        
        res = new int[stack.size()];
        
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        
        return res;
    }
}